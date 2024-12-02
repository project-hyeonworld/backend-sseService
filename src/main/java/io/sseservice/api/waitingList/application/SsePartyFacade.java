//package io.sseservice.api.sse.application;
//
//import io.sseservice.api.party.domain.PartyService;
//import io.sseservice.api.sse.domain.SseService;
//import com.toyproject.hyeonworld.common.annotation.Facade;
//import lombok.RequiredArgsConstructor;
//
///**
// * @author : hyeonwoody@gmail.com
// * @since : 24. 11. 14.
//// */
//@Facade
//@RequiredArgsConstructor
//public class SsePartyFacade {
//    private final SseService sseService;
//    private final PartyService partyService;
//
//    public void logIn(long partyId, String userName) {
//        sseService.logIn(partyId, userName);
//    }
//
//    public void gameIn(int relationType, String userName) {
//        long partyId = getPartyId(relationType);
//        sseService.gameIn(partyId, userName);
//    }
//
//    public void gameOut(int relationType, long userId, String userName) {
//        long partyId = getPartyId(relationType);
//        sseService.gameOut(partyId, userId, userName);
//    }
//
//    public void logOut(int relationType, long userId, String userName) {
//        long partyId = getPartyId(relationType);
//        sseService.logOut(partyId, userId, userName);
//    }
//
//    private long getPartyId(int relationType) {
//        return partyService.findByRelationType(relationType);
//    }
//
//
//
//}
