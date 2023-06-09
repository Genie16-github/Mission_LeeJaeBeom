package com.ll.gramgram.base.appConfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfig {
    @Getter
    private static long likeablePersonFromMax;

    @Value("${custom.likeablePerson.max}")
    public void setLikeablePersonFromMax(long likeablePersonFromMax) {
        AppConfig.likeablePersonFromMax = likeablePersonFromMax;
    }

    @Getter
    private static long likeablePersonModifyCoolTime;

    @Value("${custom.likeablePerson.modifyCoolTime}")
    public void setLikeablePersonModifyCoolTime(long likeablePersonModifyCoolTime) {
        AppConfig.likeablePersonModifyCoolTime = likeablePersonModifyCoolTime;
    }

    public static LocalDateTime genLikeablePersonModifyUnlockDate() {
        // 호감 사유를 수정했을 때 쿨타임 설정
        // 현재 시간에 likeablePersonModifyCoolTime(60 * 60 * 3, 3시간)을 더한다.
        return LocalDateTime.now().plusSeconds(likeablePersonModifyCoolTime);
    }
}
