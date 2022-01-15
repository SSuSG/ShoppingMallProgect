package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.domain.Qa;
import SongGyun.ShoppingMallProject.dto.AnswerQaDto;
import SongGyun.ShoppingMallProject.dto.QaDto;
import SongGyun.ShoppingMallProject.dto.WriteQaDto;
import SongGyun.ShoppingMallProject.repository.ItemRepository;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import SongGyun.ShoppingMallProject.repository.QaRepository;
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
public class QaService {

    private final QaRepository qaRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    //QA쓰기
    @Transactional
    public void createQa(WriteQaDto writeQaDto , Member loginMember){
        Qa qa = writeQaDto.toEntity();
        qa.setItem(itemRepository.getById(writeQaDto.getItemId()));
        qa.setMember(loginMember);
        qaRepository.save(qa);
    }

    //QA답변
    @Transactional
    public void answerQa(AnswerQaDto answerQaDto){
        Qa qa = qaRepository.findById(answerQaDto.getId()).get();
        qa.setAnswer(answerQaDto.getAnswer());
    }

    //QA내역조회
    public List<QaDto> findAllQa(Member loginMember){
        return memberRepository.findById(loginMember.getId()).
                get().getQaList().stream().map(q -> q.toDto())
                .collect(Collectors.toList());
    }

    //QA상세조회
    public QaDto readQa(Long id){
        return qaRepository.findById(id).get().toDto();
    }


}
