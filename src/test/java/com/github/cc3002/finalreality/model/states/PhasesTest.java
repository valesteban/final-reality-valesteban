package com.github.cc3002.finalreality.model.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhasesTest extends AbstractPhase {

    @BeforeEach
    void setUp(){
        super.basicSetUp();
    }

    @Test
    public void initialPhaseTest(){
        assertEquals(controller.getPhase(),"FirstCharacterPhase");
    }

}
