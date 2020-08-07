package co.com.s4n.demo_bc2.infrastructure.util;


import io.vavr.control.Option;

public class MonadUtil {

    public static Option<String> getOption(String charSequence) {
        return charSequence != null || "".compareTo(charSequence) != 0 ? Option.of(charSequence) : Option.none();
    }

    public static Option<String> getOptionEnv(String charSequence) {
        return getOption(System.getenv(charSequence));
    }
}
