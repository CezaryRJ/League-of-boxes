package Effects;

import Stats.Stat;

public interface EffectInterface {

void settid(int a);
int getid();
void desc();
String getname();
void print();
Stat[] applyeffect(Stat[] a);

}
