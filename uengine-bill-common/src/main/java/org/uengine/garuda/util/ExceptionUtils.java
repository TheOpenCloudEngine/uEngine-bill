/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.uengine.garuda.util;

import org.slf4j.Logger;
import org.slf4j.helpers.MessageFormatter;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Exception Utilty.
 *
 * @author Seungpil, Park
 * @since 0.2
 */
public class ExceptionUtils {

    /**
     * 메시지 패턴과 파라미터를 기반으로 예외 메시지를 구성한다.
     *
     * @param message SLF4J 형식의 메시지 패턴
     * @param args    메시지 패턴의 인자와 매핑하는 파라미터값
     * @return 예외 메시지
     */
    public static String getMessage(String message, Object... args) {
        return MessageFormatter.arrayFormat(message, args).getMessage();
    }

    /**
     * 발생한 예외에 대해서 ROOT Cause를 반환한다.
     *
     * @param exception 발생한 Exception
     * @return ROOT Cause
     */
    public static Throwable getRootCause(Exception exception) {
        return org.apache.commons.lang.exception.ExceptionUtils.getRootCause(exception);
    }

    /**
     * 발생한 예외에 대해서 Full Stack Trace를 logger에 경로 레벨로 남긴다.
     *
     * @param exception Exception
     * @param logger    SLF4J Logger
     */
    public static void printFullStackTrace(Exception exception, Logger logger) {
        logger.warn(org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(exception));
    }

    /**
     * 발생한 예외에 대해서 Full Stack Trace를 반환한다.
     *
     * @param exception Exception
     * @return Full Stack Trace
     */
    public static String getFullStackTrace(Exception exception) {
        return org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(exception);
    }

    /**
     * 발생한 예외에 대해 httpServletResponse 를 수행한다.
     *
     * @param exception
     * @param response
     */
    public static void httpExceptionResponse(Exception exception, HttpServletResponse response) {
        try {
            exception.printStackTrace();
            Map map = new HashMap();

            String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(exception);
            map.put("error", StringUtils.isEmpty(exception.getMessage()) ? "Bad Request" : exception.getMessage());
            map.put("error_description", fullStackTrace);

            String marshal = JsonUtils.marshal(map);

            response.setStatus(400);
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.getWriter().write(marshal);

        } catch (Exception ex) {
            response.setStatus(400);
        }
    }


    /**
     * 발생한 예외에 대해 httpServletResponse 를 수행한다. (Killbill Style)
     *
     * @param exception
     * @param response
     */
    public static void httpExceptionKBResponse(Exception exception, HttpServletResponse response) {
        try {
            exception.printStackTrace();
            Map map = new HashMap();

            String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(exception);

            map.put("className", exception.getClass().getName());
            map.put("code", null);
            map.put("message", StringUtils.isEmpty(exception.getMessage()) ? "Bad Request" : exception.getMessage());
            map.put("causeClassName", exception.getCause() != null ? exception.getCause().getClass().getName() : null);

            if (exception.getCause() != null) {
                map.put("causeMessage", exception.getCause().getMessage() != null ? exception.getCause().getMessage() : null);
            } else {
                map.put("causeMessage", null);
            }
            map.put("stackTrace", fullStackTrace);

            String marshal = JsonUtils.marshal(map);
            //String prettyPrint = JsonFormatterUtils.prettyPrint(marshal);
            //System.out.println(marshal);

            response.setStatus(400);
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.getWriter().write(marshal);

        } catch (Exception ex) {
            response.setStatus(400);
        }
    }
}
