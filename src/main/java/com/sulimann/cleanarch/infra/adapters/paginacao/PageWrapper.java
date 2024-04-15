package com.sulimann.cleanarch.infra.adapters.paginacao;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sulimann.cleanarch.core.utils.page.IPage;

public class PageWrapper<T> implements IPage<T> {

  private List<T> content;
  private Pageable pageable;
  private int totalPages;
  private long totalElements;
  private boolean last;
  private int size;
  private int number;
  private Sort sort;
  private boolean first;
  private int numberOfElements;
  private boolean empty;
  private Page<T> page;

  public PageWrapper(Page<T> page) {
    this.content = page.getContent();
    this.pageable = page.getPageable();
    this.totalPages = page.getTotalPages();
    this.totalElements = page.getTotalElements();
    this.last = page.isLast();
    this.size = page.getSize();
    this.number = page.getNumber();
    this.sort = page.getSort();
    this.first = page.isFirst();
    this.numberOfElements = page.getNumberOfElements();
    this.empty = page.isEmpty();
    this.page = page;
  }

  @Override
  public List<T> getContent() {
    return this.content;
  }

  @Override
  public int getTotalPages() {
    return this.totalPages;
  }

  @Override
  public long getTotalElements() {
    return this.totalElements;
  }

  @Override
  public <U> Page<U> map(Function<? super T, ? extends U> converter) {
    return this.page.map(converter);
  }

  @Override
  public int getNumber() {
    return this.number;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public int getNumberOfElements() {
    return this.numberOfElements;
  }

  @Override
  public boolean hasContent() {
    return this.page.hasContent();
  }

  @Override
  public Sort getSort() {
    return this.sort;
  }

  @Override
  public boolean isFirst() {
    return this.first;
  }

  @Override
  public boolean isLast() {
    return this.last;
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
  public Pageable nextPageable() {
    return this.page.nextPageable();
  }

  @Override
  public Pageable previousPageable() {
    return this.page.previousPageable();
  }

  @Override
  public Iterator<T> iterator() {
    return this.page.iterator();
  }

  @Override
  public Pageable getPageable() {
    return pageable;
  }

  @Override
  public boolean isEmpty() {
    return empty;
  }

}
