package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Notice;
import SongGyun.ShoppingMallProject.dto.NoticeDto;
import SongGyun.ShoppingMallProject.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;


    //공지사항 작성
    @Transactional
    public void createNotice(NoticeDto noticeDto , Member loginMember) {
        Notice notice = noticeDto.toEntity();
        notice.setMember(loginMember);
        noticeRepository.save(notice);
    }
}
