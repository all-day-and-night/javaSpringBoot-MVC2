package hello.itemservice.domain.item;

import lombok.Data;

/**
 * @Data는 의도치 않은 기능까지 제공하여 위험성을 가지고 있음
 * @Getter, @Setter를 사용하도록 하자
 */
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){

    }

    public Item(String itemName, Integer price, Integer quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
