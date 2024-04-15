package com.sulimann.cleanarch.infra.adapters.paginacao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sulimann.cleanarch.core.utils.page.IPageable;

public class PageableWrapper implements IPageable{

  private final Pageable pageable;

  public PageableWrapper(Pageable pageable) {
    this.pageable = pageable;
  }

  @Override
  public int getPageNumber() {
    return this.pageable.getPageNumber();
  }

  @Override
  public int getPageSize() {
    return this.pageable.getPageSize();
  }

  @Override
  public long getOffset() {
   return this.pageable.getOffset();
  }

  @Override
  public Sort getSort() {
    return this.pageable.getSort();
  }

  @Override
  public Pageable next() {
    return this.pageable.next();
  }

  @Override
  public Pageable previousOrFirst() {
    return this.pageable.previousOrFirst();
  }

  @Override
  public Pageable first() {
    return this.pageable.first();
  }

  @Override
  public Pageable withPage(int pageNumber) {
    return this.pageable.withPage(pageNumber);
  }

  @Override
  public boolean hasPrevious() {
    return this.pageable.hasPrevious();
  }

}
