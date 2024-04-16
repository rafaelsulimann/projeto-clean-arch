package com.sulimann.cleanarch.infra.adapters.paginacao;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sulimann.cleanarch.core.utils.page.IOrder;
import com.sulimann.cleanarch.core.utils.page.ISort;

@JsonPropertyOrder({
  "orders",
  "isSorted",
  "isUnsorted",
  "isEmpty"
})
public class SortAdapter implements ISort{

  private List<IOrder> orders;
  private boolean isSorted;
  private boolean isUnsorted;
  private boolean isEmpty;

  public SortAdapter(Sort sort) {
    this.orders = sort.get().map(order -> (IOrder) new OrderAdapter(order)).toList();
    this.isSorted = sort.isSorted();
    this.isUnsorted = sort.isUnsorted();
    this.isEmpty = sort.isEmpty();
  }

  @Override
  public List<IOrder> getOrders() {
    return this.orders;
  }

  @Override
  public boolean isSorted() {
    return this.isSorted;
  }

  @Override
  public boolean isUnsorted() {
    return this.isUnsorted;
  }

  @Override
  public boolean isEmpty() {
    return this.isEmpty;
  }

}
