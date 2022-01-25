package SongGyun.ShoppingMallProject.controller;

import SongGyun.ShoppingMallProject.dto.ItemDto;
import SongGyun.ShoppingMallProject.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemContorller {

    private final ItemService itemService;
    //상품상세페이지
    @GetMapping("item/{itemId}")
    public ItemDto viewItem(
            @PathVariable Long itemId
    ) throws IOException {
        return itemService.readItem(itemId);
    }

    /*
    //상품페이지
    @GetMapping("/item")

    //outer 페이지
    @GetMapping("/item/outer")

    //Top페이지
    @GetMapping("/item/top")

    //bottom 페이지
    @GetMapping("/item/bottom")

    //shoes 페이지
    @GetMapping("/item/shoes")

    //acc 페이지
    @GetMapping("/item/acc")



    //상품구매하기
    @PostMapping("item/{itemId}")

     */
}
