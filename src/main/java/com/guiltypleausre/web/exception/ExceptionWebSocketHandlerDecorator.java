/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guiltypleausre.web.exception;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

/**
 * An exception handling {@link WebSocketHandlerDecorator}.
 * Traps all {@link Throwable} instances that escape from the decorated
 * handler and closes the session with {@link CloseStatus#SERVER_ERROR}.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public class ExceptionWebSocketHandlerDecorator extends WebSocketHandlerDecorator {

	public ExceptionWebSocketHandlerDecorator(WebSocketHandler delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

}