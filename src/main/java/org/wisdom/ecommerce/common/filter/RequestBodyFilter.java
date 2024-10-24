package org.wisdom.ecommerce.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class RequestBodyFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    chain.doFilter(new MultiReadHttpServletRequest(request), response);
  }

  private static class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

    private ByteArrayOutputStream cachedBytes;

    public MultiReadHttpServletRequest(HttpServletRequest request) {
      super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
      if (cachedBytes == null) {
        cacheInputStream();
      }

      return new CachedServletInputStream(cachedBytes.toByteArray());
    }

    @Override
    public BufferedReader getReader() throws IOException {
      return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    private void cacheInputStream() throws IOException {
      cachedBytes = new ByteArrayOutputStream();
      IOUtils.copy(super.getInputStream(), cachedBytes);
    }
  }

  private static class CachedServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream buffer;

    public CachedServletInputStream(byte[] contents) {
      this.buffer = new ByteArrayInputStream(contents);
    }

    @Override
    public int read() {
      return buffer.read();
    }

    @Override
    public boolean isFinished() {
      return buffer.available() == 0;
    }

    @Override
    public boolean isReady() {
      return true;
    }

    @Override
    public void setReadListener(ReadListener listener) {
      throw new RuntimeException("Not implemented");
    }
  }
}