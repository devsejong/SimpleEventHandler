package com.example.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class EventService implements ApplicationContextAware {

    private List<EventHandler> eventHandlers;

    /**
     * 이벤트를 실행합니다.
     *
     * @param event 이벤트 타입 확장 인스턴스
     * @param <T>   이벤트 타입
     */
    public <T extends Event> void notifyEvent(T event) {
        eventHandlers.stream()
                .filter(e -> e.canHandle(event))
                .forEach(e -> e.handle(event));
    }

    /**
     * 이벤트를 사용할 수 있는 빈을 찾은다음 eventHandlers로 저장합니다.
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, EventHandler> eventHandlerBeans = applicationContext.getBeansOfType(EventHandler.class);

        //수정할 수 없도록 막긔
        this.eventHandlers = Collections.unmodifiableList(
                eventHandlerBeans.values().stream().collect(toList())
        );
    }

}
