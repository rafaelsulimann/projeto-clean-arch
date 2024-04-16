package com.sulimann.cleanarch.infra.adapters.paginacao;

import org.springframework.data.domain.Pageable;

import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.page.ISort;

public class PageableAdapter implements IPageable{

  private final Pageable pageable;

  public PageableAdapter(Pageable pageable) {
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
  public ISort getSort() {
    return new SortAdapter(this.pageable.getSort());
  }

  @Override
  public IPageable next() {
    return new PageableAdapter(this.pageable.next());
  }

  @Override
  public IPageable previousOrFirst() {
    return new PageableAdapter(this.pageable.previousOrFirst());
  }

  @Override
  public IPageable first() {
    return new PageableAdapter(this.pageable.first());
  }

  @Override
  public IPageable withPage(int pageNumber) {
    return new PageableAdapter(this.pageable.withPage(pageNumber));
  }

  @Override
  public boolean hasPrevious() {
    return this.pageable.hasPrevious();
  }

  @Override
  public boolean isPaged() {
    return this.pageable.isPaged();
  }

  @Override
  public boolean isUnpaged() {
    return this.pageable.isUnpaged();
  }

}
