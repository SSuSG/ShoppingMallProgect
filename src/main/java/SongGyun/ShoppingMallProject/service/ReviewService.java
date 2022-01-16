package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Review;
import SongGyun.ShoppingMallProject.dto.ReviewDto;
import SongGyun.ShoppingMallProject.dto.WriteReviewDto;
import SongGyun.ShoppingMallProject.repository.ItemRepository;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import SongGyun.ShoppingMallProject.repository.ReviewRepository;
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
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    //리뷰 작성
    @Transactional
    public void createReview(WriteReviewDto writeReviewDto , Long memberId){
        Review createReview = writeReviewDto.createReview();
        Item reviewItem = itemRepository.findById(writeReviewDto.getItemId()).get();
        Member reviewMember = memberRepository.findById(memberId).get();

        createReview.setItem(reviewItem);
        createReview.setMember(reviewMember);
        reviewRepository.save(createReview);
    }


}
