class : kind of fn jisme data members or fns dono hote hai 

  eg public static person{
  int age;

  void printAge(){
    Syso(age);
  }
}

void main(){
  person p1 = new person();
  p1.age = 10;
  p1.printAge();
}


objects : heap me jo instance banta hai jha data memebers or value store hoti hai 
      eg p1

stack : jo object declare kis hai heap me uska reference (4k, 5k...)

fn call using objects : fnname( obj1, obj2,....)
