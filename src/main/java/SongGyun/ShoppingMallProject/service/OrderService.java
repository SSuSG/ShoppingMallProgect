package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.dto.OrderDto;
import SongGyun.ShoppingMallProject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //모든 주문 내역 조회
    public List<OrderDto> findAllOrders() {
        log.info("OrderService : findAllOrders");
        return orderRepository.findAll()
                .stream().map(order -> order.toDto(order))
                .collect(Collectors.toList());
    }


}
