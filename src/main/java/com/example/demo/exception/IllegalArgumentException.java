package com.example.demo.exception;

import lombok.Getter;

@Getter
public class IllegalArgumentException extends RuntimeException {

  private final String description;

  public IllegalArgumentException(String message, String description) {
    super(message);
    this.description = description;
  }
}