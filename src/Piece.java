/**
 * Created by Kyle on 10/10/2016.
 */
public enum Piece {
 EMPTY("_"), RED("X"), BLACK("O");

 String draw;

 Piece(String str)
 {
  draw = str;
 }

 @Override
 public String toString() {
  return draw;
 }
}
