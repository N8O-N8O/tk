package com.urm.sync.codec.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Sync message
 */
public class SyncInfo implements Serializable {

  /**
   * message id
   */
  private String id;
  /**
   * sequence id
   */
  private String sequenceId;
  /**
   * timestamp
   */
  private long timestamp;
  /**
   * 市场
   */
  private String exchId;
  /**
   * 证券代码
   */
  private String stkId;
  /**
   * 昨日收盘价
   */
  private BigDecimal closePrice;
  /**
   * 最新价
   */
  private BigDecimal newPrice;
  /**
   * 涨停价
   */
  private BigDecimal maxOrderPrice;
  /**
   * 跌停价
   */
  private BigDecimal minOrderPrice;
  /**
   * 平均价
   */
  private BigDecimal knockAvgPrice;
  /**
   * 总成交数量
   */
  private int totalMktKnockQty;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSequenceId() {
    return sequenceId;
  }

  public void setSequenceId(String sequenceId) {
    this.sequenceId = sequenceId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getExchId() {
    return exchId;
  }

  public void setExchId(String exchId) {
    this.exchId = exchId;
  }

  public String getStkId() {
    return stkId;
  }

  public void setStkId(String stkId) {
    this.stkId = stkId;
  }

  public BigDecimal getClosePrice() {
    return closePrice;
  }

  public void setClosePrice(BigDecimal closePrice) {
    this.closePrice = closePrice;
  }

  public BigDecimal getNewPrice() {
    return newPrice;
  }

  public void setNewPrice(BigDecimal newPrice) {
    this.newPrice = newPrice;
  }

  public BigDecimal getMaxOrderPrice() {
    return maxOrderPrice;
  }

  public void setMaxOrderPrice(BigDecimal maxOrderPrice) {
    this.maxOrderPrice = maxOrderPrice;
  }

  public BigDecimal getMinOrderPrice() {
    return minOrderPrice;
  }

  public void setMinOrderPrice(BigDecimal minOrderPrice) {
    this.minOrderPrice = minOrderPrice;
  }

  public BigDecimal getKnockAvgPrice() {
    return knockAvgPrice;
  }

  public void setKnockAvgPrice(BigDecimal knockAvgPrice) {
    this.knockAvgPrice = knockAvgPrice;
  }

  public int getTotalMktKnockQty() {
    return totalMktKnockQty;
  }

  public void setTotalMktKnockQty(int totalMktKnockQty) {
    this.totalMktKnockQty = totalMktKnockQty;
  }

  @Override
  public String toString() {
    return "SyncInfo{" +
        "id='" + id + '\'' +
        ", sequenceId='" + sequenceId + '\'' +
        ", timestamp=" + timestamp +
        ", exchId='" + exchId + '\'' +
        ", stkId='" + stkId + '\'' +
        ", closePrice=" + closePrice +
        ", newPrice=" + newPrice +
        ", maxOrderPrice=" + maxOrderPrice +
        ", minOrderPrice=" + minOrderPrice +
        ", knockAvgPrice=" + knockAvgPrice +
        ", totalMktKnockQty=" + totalMktKnockQty +
        '}';
  }
}
