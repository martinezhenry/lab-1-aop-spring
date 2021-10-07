package com.hvs.lab.aop.controller.implementations;

import com.hvs.lab.aop.aspect.Timer;
import com.hvs.lab.aop.controller.contrats.IDelayRandomController;
import lombok.SneakyThrows;
import org.apache.commons.math3.random.RandomAdaptor;
import org.apache.commons.math3.random.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * DelayRandomController
 * <p>
 * DelayRandomController class.
 * <p>
 * <p>
 * ESTE COMPONENTE FUE CONSTRUIDO SIGUIENDO LOS ESTANDARES DE DESARROLLO Y EL PROCEDIMIENTO
 * DE DESARROLLO DE APLICACIONES DE NOVOPAYMENT Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * PROPIEDAD INTELECTUAL Y DERECHOS DE AUTOR.
 *
 * @author Novopayment Inc.
 * @author hmartinez@novopayment.com
 * @since 7/10/21
 */
@RestController()
@RequestMapping("${base-random-delay}")
public class DelayRandomController implements IDelayRandomController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DelayRandomController.class);
    @Value("${default-max}")
    private long defaultMax;
    @Value("${default-min}")
    private long defaultMin;

    @SneakyThrows
    @Override
    @GetMapping(value = {"/${action-delay}/{min}/{max}"})
    public long delay(@PathVariable long min, @PathVariable long max) {

        LOGGER.info("into my method");
        if (min == 0) {
            min = defaultMin;
        }
        if (max == 0) {
            max = defaultMax;
        }
        if (min < 0){
            throw new IllegalArgumentException("min value should not be < 0");
        }
        if (max < min) {
            throw new IllegalArgumentException("max value should not be bigger that min value");
        }
        long delay = min + (long) (Math.random() * (max - min));
        sleep((delay * 1000));
        return delay;
    }
}
