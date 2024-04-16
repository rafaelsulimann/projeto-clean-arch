package com.sulimann.cleanarch.infra.adapters.paginacao;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.page.ISort;

@JsonPropertyOrder({
  "content",
  "pageable",
  "totalPages",
  "totalElements",
  "numberOfElements",
  "size",
  "number",
  "sort",
  "isEmpty",
  "isFirst",
  "isLast"
})
public class PageAdapter<T> implements IPage<T>{

  private List<T> content;
  private IPageable pageable;
  private int totalPages;
  private Long totalElements;
  private boolean isLast;
  private int size;
  private int number;
  private ISort sort;
  private boolean isFirst;
  private int numberOfElements;
  private boolean isEmpty;
  private final Page<T> page;

  public PageAdapter(Page<T> page) {
    this.content = page.getContent();
    this.pageable = new PageableAdapter(page.getPageable());
    this.totalPages = page.getTotalPages();
    this.totalElements = page.getTotalElements();
    this.isLast = page.isLast();
    this.size = page.getSize();
    this.number = page.getNumber();
    this.sort = new SortAdapter(page.getSort());
    this.isFirst = page.isFirst();
    this.numberOfElements = page.getNumberOfElements();
    this.isEmpty = page.isEmpty();
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
  public <U> IPage<U> map(Function<? super T, ? extends U> converter) {
    return new PageAdapter<>(this.page.map(converter));
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
    return this.content.isEmpty();
  }

  @Override
  public ISort getSort() {
    return this.sort;
  }

  @Override
  public boolean isFirst() {
    return this.isFirst;
  }

  @Override
  public boolean isLast() {
    return this.isLast;
  }

  @Override
  public boolean hasNext() {
    return !this.isLast;
  }

  @Override
  public boolean hasPrevious() {
    return !this.isFirst;
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
    return this.pageable;
  }

  @Override
  public boolean isEmpty() {
    return this.isEmpty;
  }

}
