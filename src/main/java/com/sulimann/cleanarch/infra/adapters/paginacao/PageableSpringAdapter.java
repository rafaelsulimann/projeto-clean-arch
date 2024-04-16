package com.sulimann.cleanarch.infra.adapters.paginacao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.sulimann.cleanarch.core.utils.page.IPageable;

public class PageableSpringAdapter implements Pageable{

  private final IPageable pageable;

  public PageableSpringAdapter(IPageable pageable) {
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
    return new SortSpringAdapter(this.pageable.getSort().getOrders().stream().map(iorder -> new Order(Direction.valueOf(iorder.getDirection().name()), iorder.getProperty())).toList());
  }

  @Override
  public Pageable next() {
    return new PageableSpringAdapter(this.pageable.next());
  }

  @Override
  public Pageable previousOrFirst() {
    return new PageableSpringAdapter(this.pageable.previousOrFirst());
  }

  @Override
  public Pageable first() {
    return new PageableSpringAdapter(this.pageable.first());
  }

  @Override
  public Pageable withPage(int pageNumber) {
    return new PageableSpringAdapter(this.pageable.withPage(pageNumber));
  }

  @Override
  public boolean hasPrevious() {
    return this.pageable.hasPrevious();
  }

}
