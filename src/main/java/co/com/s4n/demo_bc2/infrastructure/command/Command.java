package co.com.s4n.demo_bc2.infrastructure.command;

public interface Command <R, P>{
    P execute(R request);
}
