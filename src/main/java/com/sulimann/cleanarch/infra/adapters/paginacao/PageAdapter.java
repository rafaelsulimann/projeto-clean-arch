package com.sulimann.cleanarch.infra.adapters.paginacao;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.page.ISort;

public class PageAdapter<T> implements IPage<T>{

  private final Page<T> page;

  public PageAdapter(Page<T> page) {
    this.page = page;
  }

  @Override
  public List<T> getContent() {
    return this.page.getContent();
  }

  @Override
  public int getTotalPages() {
    return this.page.getTotalPages();
  }

  @Override
  public long getTotalElements() {
    return this.page.getTotalElements();
  }

  @Override
  public <U> IPage<U> map(Function<? super T, ? extends U> converter) {
    return new PageAdapter<>(this.page.map(converter));
  }

  @Override
  public int getNumber() {
    return this.page.getNumber();
  }

  @Override
  public int getSize() {
    return this.page.getSize();
  }

  @Override
  public int getNumberOfElements() {
    return this.page.getNumberOfElements();
  }

  @Override
  public boolean hasContent() {
    return this.page.hasContent();
  }

  @Override
  public ISort getSort() {
    return new SortAdapter(this.page.getSort());
  }

  @Override
  public boolean isFirst() {
    return this.page.isFirst();
  }

  @Override
  public boolean isLast() {
    return this.page.isLast();
  }

  @Override
  public boolean hasNext() {
    return this.page.hasNext();
  }

  @Override
  public boolean hasPrevious() {
    return this.page.hasPrevious();
  }

  @Override
  public IPageable nextPageable() {
    return new PageableAdapter(this.page.nextPageable());
  }

  @Override
  public IPageable previousPageable() {
    return new PageableAdapter(this.page.previousPageable());
  }

  @Override
  public Iterator<T> iterator() {
    return this.page.iterator();
  }

  @Override
  public IPageable getPageable() {
    return new PageableAdapter(this.page.getPageable());
  }

  @Override
  public boolean isEmpty() {
    return this.page.isEmpty();
  }

}
