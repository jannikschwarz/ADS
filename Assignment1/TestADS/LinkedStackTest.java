import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest
{
  private LinkedStack<Token> linkedStack;

  @BeforeEach void setUp()
  {
    linkedStack = new LinkedStack<Token>();
  }

  @AfterEach void tearDown()
  {
    linkedStack = new LinkedStack<Token>();
  }

  @Test void isEmptyTrue()
  {
    assertEquals(true, linkedStack.isEmpty());
  }
  @Test void isEmptyFalse()
  {
    Token token = new Operand(2);
    linkedStack.push(token);
    assertEquals(false, linkedStack.isEmpty());
  }

  @Test void push()
  {
    Token token = new Operand(4);
    linkedStack.push(token);
    assertEquals(token, linkedStack.pop());
  }

  @Test void popCorrect()
  {
    Token token = new Operand(4);
    linkedStack.push(token);
    assertEquals(token, linkedStack.pop());
  }

  @Test void popException()
  {
    assertThrows(EmptyStackException.class, ()->{linkedStack.pop();});
  }
}