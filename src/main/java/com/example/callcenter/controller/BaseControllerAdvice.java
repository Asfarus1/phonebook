package com.example.callcenter.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {

    private static final String DATE_FORMAT = "dd.MM.yyyy";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                Date.class,
                new PropertyEditorSupport() {
                    @Override
                    public String getAsText() {
                        Date date = (Date) getValue();
                        if (date != null) {
                            try {
                                return dateFormat.format(date);
                            } catch (Throwable t) {
                                log.trace("PropertyEditor Date getAsText({})", date, t);
                            }
                        }

                        return StringUtils.EMPTY;
                    }

                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        if (StringUtils.isNotEmpty(text)) {
                            try {
                                Date date = dateFormat.parse(text);
                                setValue(date);
                                return;
                            } catch (Throwable t) {
                                log.trace("PropertyEditor Date setAsText({})", text, t);
                            }
                        }
                        setValue(null);
                    }
                }
        );
    }
}
