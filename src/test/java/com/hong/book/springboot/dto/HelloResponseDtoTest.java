// gradle 4.10.2
package com.hong.book.springboot.dto;

import com.hong.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // aseertj => 테스트 검증 라이브러리의 검증 메소드
        // 메소드 체이닝이 지원되어 isEqualTo와 같이 사용 가능
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
