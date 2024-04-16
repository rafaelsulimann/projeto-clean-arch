package com.sulimann.cleanarch.core.utils.page;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public interface IPage<T> {
  List<T> getContent();
  int getTotalPages();
  long getTotalElements();
  <U> IPage<U> map(Function<? super T, ? extends U> converter);
  int getNumber();
  int getSize();
  int getNumberOfElements();
  boolean hasContent();
  ISort getSort();
  boolean isFirst();
  boolean isLast();
  boolean hasNext();
  boolean hasPrevious() ;
  IPageable nextPageable();
  IPageable previousPageable();
  Iterator<T> iterator();
  IPageable getPageable();
  boolean isEmpty();
}
