package com.hvs.lab.aop.controller.contrats;

import org.springframework.web.bind.annotation.PathVariable;

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
public interface IDelayRandomController {

    long delay(long min, long max);

}
