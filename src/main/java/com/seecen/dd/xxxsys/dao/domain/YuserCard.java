package com.seecen.dd.xxxsys.dao.domain;

import javax.persistence.*;

/**
 * 会员卡表 Y_USER_CARD
 */
@Table(name = "y_user_card")
public class YuserCard {
    @Id
    @Column(name = "card_id")
    private Integer cardId;

    @Column(name = "card_type")
    private String cardType;

    /**
     * @return card_id
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     * @param cardId
     */
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    /**
     * @return card_type
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }
}