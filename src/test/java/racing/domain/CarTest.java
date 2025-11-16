package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        //given
        String name = "pobi";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차는_처음에_0의_위치에_있다() {
        //given
        Car car = new Car("pobi");

        //when
        int position = car.getPosition();

        //then
        assertThat(position).isEqualTo(0);
    }

    @Test
    void 랜덤값이_4이상이면_자동차는_전진할_수_있다() {
        //given
        Car car = new Car("pobi");

        //when
        car.move(5);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_여러번_전진할_수_있다() {
        //given
        Car car = new Car("pobi");

        //when
        car.move(5);
        car.move(6);
        car.move(4);

        //then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 랜덤값이_4미만이면_전진하지_않는다() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        //when & then
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    void 이름이_5자면_정상() {
        //when & then
        assertThatCode(() -> new Car("12345"))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름이_null이면_예외가_발생한다() {
        //when & then
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름");
    }

    @Test
    void 이름이_빈_문자열이면_예외가_발생한다() {
        //when & then
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름");
    }
}
