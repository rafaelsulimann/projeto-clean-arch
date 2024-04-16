package com.sulimann.cleanarch.core.utils.page;

public interface IPageable {
  int getPageNumber();
  int getPageSize();
  long getOffset();
  ISort getSort();
  boolean isPaged();
  boolean isUnpaged();
  IPageable next();
  IPageable previousOrFirst();
  IPageable first();
  IPageable withPage(int pageNumber);
  boolean hasPrevious();
}
