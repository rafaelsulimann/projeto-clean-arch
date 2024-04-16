package com.sulimann.cleanarch.infra.adapters.paginacao;

import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.page.ISort;

@JsonPropertyOrder({
  "pageNumber",
  "pageSize",
  "sort",
  "offset",
  "isPaged",
  "isUnpaged"
})
public class PageableAdapter implements IPageable{

  private int pageNumber;
  private int pageSize;
  private ISort sort;
  private Long offset;
  private boolean isPaged;
  private boolean isUnpaged;
  private final Pageable pageable;

  public PageableAdapter(Pageable pageable) {
    this.pageNumber = pageable.getPageNumber();
    this.pageSize = pageable.getPageSize();
    this.sort = new SortAdapter(pageable.getSort());
    this.offset = pageable.getOffset();
    this.isPaged = pageable.isPaged();
    this.isUnpaged = pageable.isUnpaged();
    this.pageable = pageable;
  }

  @Override
  public int getPageNumber() {
    return this.pageNumber;
  }

  @Override
  public int getPageSize() {
    return this.pageSize;
  }

  @Override
  public long getOffset() {
    return this.offset;
  }

  @Override
  public ISort getSort() {
    return this.sort;
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
    return this.isPaged;
  }

  @Override
  public boolean isUnpaged() {
    return this.isUnpaged;
  }

}
