/* Robot.java */
/* Generated By:JavaCC: Do not edit this line. Robot.java */
package uniandes.lym.robot.control;

import uniandes.lym.robot.kernel.*;
import uniandes.lym.robot.view.Console;

import java.awt.Point;
import java.io.*;
import java.util.Vector;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Robot implements RobotConstants {


        private RobotWorldDec world;


        void setWorld(RobotWorld w) {
                world = (RobotWorldDec) w;
        }

        String salida=new String();
        boolean isValidMOV(String token) {
        return token.equals("Mov");
    }

    boolean isValidRIGHT(String token) {
        return token.equals("RIGHT");
    }

    boolean isValidPUT(String token) {
        return token.equals("Put");
    }

    boolean isValidPICK(String token) {
        return token.equals("Pick");
    }

    boolean isValidPOP(String token) {
        return token.equals("Pop");
    }

    boolean isValidGO(String token) {
        return token.equals("GO");
    }

    boolean isValidHOP(String token) {
        return token.equals("HOP");
    }

    boolean isValidBALLOONS(String token) {
        return token.equals("BALLOONS");
    }

    boolean isValidCHIPS(String token) {
        return token.equals("CHIPS");
    }

    boolean isValidIF(String token) {
        return token.equals("if");
    }

    boolean isValidELSE(String token) {
        return token.equals("else");
    }

    boolean isValidPROC(String token) {
        return token.equals("proc");
    }

    boolean isValidREPEAT(String token) {
        return token.equals("repeat");
}
        boolean isValidNUM(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

//boolean command(uniandes.lym.robot.view.Console sistema) :
  final public         boolean command(Console sistema) throws ParseException {int x,y;
                salida=new String();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case MOV:
    case RIGHT:
    case PUT:
    case PICK:
    case POP:
    case GO:
    case HOP:{
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case RIGHT:{
          jj_consume_token(RIGHT);
          jj_consume_token(20);
          jj_consume_token(21);
world.turnRight();salida = "Command: Turnright";
          break;
          }
        case MOV:{
          jj_consume_token(MOV);
          jj_consume_token(20);
          x = num();
          jj_consume_token(21);
world.moveForward(x,false);salida = "Command: Moveforward ";
          break;
          }
        case HOP:{
          jj_consume_token(HOP);
          jj_consume_token(20);
          x = num();
          jj_consume_token(21);
world.moveForward(x,true);salida = "Command:Jumpforward ";
          break;
          }
        case GO:{
          jj_consume_token(GO);
          jj_consume_token(20);
          x = num();
          jj_consume_token(22);
          y = num();
          jj_consume_token(21);
world.setPostion(x,y);salida = "Command:GO ";
          break;
          }
        case PUT:{
          jj_consume_token(PUT);
          jj_consume_token(20);
          put();
          jj_consume_token(21);
          break;
          }
        case PICK:{
          jj_consume_token(PICK);
          jj_consume_token(20);
          get();
          jj_consume_token(21);
          break;
          }
        case POP:{
          jj_consume_token(POP);
          jj_consume_token(20);
          x = num();
          jj_consume_token(21);
world.popBalloons(x); salida = "Comando:  Pop";
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(23);
try {
                                 Thread.sleep(900);
                    } catch (InterruptedException e) {
                                        System.err.format("IOException: %s%n", e);
                            }

                        sistema.printOutput(salida);
                        {if ("" != null) return true;}
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MOV:
        case RIGHT:
        case PUT:
        case PICK:
        case POP:
        case GO:
        case HOP:{
          ;
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
      }
      break;
      }
    case 0:{
      jj_consume_token(0);
{if ("" != null) return false;}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public void put() throws ParseException {int f=1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CHIPS:{
      jj_consume_token(CHIPS);
      jj_consume_token(22);
      f = num();
world.putChips(f); salida = "Command:  Put Chips";
      break;
      }
    case BALLOONS:{
      jj_consume_token(BALLOONS);
      jj_consume_token(22);
      f = num();
world.putBalloons(f); salida = "Command:  Put Balloons";
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void get() throws ParseException {int f=1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CHIPS:{
      jj_consume_token(CHIPS);
      jj_consume_token(22);
      f = num();
world.pickChips(f);salida = "Command:  Pick chips";
      break;
      }
    case BALLOONS:{
      jj_consume_token(BALLOONS);
      jj_consume_token(22);
      f = num();
world.grabBalloons(f);salida="Command:  Pick balloons";
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

/**
	 * Unsigned decimal number
	 * @return the corresponding value of the string
	 * @error  corresponding value is too large
	 */
  final public 
        int num() throws ParseException, Error {int total=1;
    jj_consume_token(NUM);
try
                        {
                                total = Integer.parseInt(token.image);
                        }
                        catch (NumberFormatException ee)
                        {
                                {if (true) throw new Error("Number out of bounds: "+token.image+" !!");}
                        }
                        {if ("" != null) return total;}
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public RobotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0xfe0,0xfe0,0xfe1,0x3000,0x3000,};
	}

  /** Constructor with InputStream. */
  public Robot(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Robot(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Robot(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new RobotTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Robot(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[24];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 5; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 24; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  }
