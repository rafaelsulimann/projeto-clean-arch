package com.sulimann.cleanarch.infra.adapters.paginacao;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.sulimann.cleanarch.core.utils.page.IOrder;
import com.sulimann.cleanarch.core.utils.page.ISort;

public class SortAdapter implements ISort{

  private final Sort sort;

  public SortAdapter(Sort sort) {
    this.sort = sort;
  }

  @Override
  public List<IOrder> getOrder() {
    return this.sort.get().map(order -> (IOrder) new OrderAdapter(order)).toList();
  }

  @Override
  public boolean isSorted() {
    return this.sort.isSorted();
  }

  @Override
  public boolean isUnsorted() {
    return this.sort.isUnsorted();
  }

  @Override
  public boolean isEmpty() {
    return this.sort.isEmpty();
  }

}
