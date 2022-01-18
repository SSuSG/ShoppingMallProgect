package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.dto.BasketDto;
import SongGyun.ShoppingMallProject.repository.BasketItemRepository;
import SongGyun.ShoppingMallProject.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;

    //장바구니 담기
    public void addBasketItemToBasket(){

    }



    //장바구니 조회
    public void viewMyBasket(){

    }


}
