import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class App {
// String[] nome = {"Testemunha Eterna","Pirata de Aeroveleiro","Etergênito Talentoso", "Senhora dos Amaldiçoados", "Peão de Ulamog"};
// int[] poder = {2, 1, 2, 3, 2};
// int[] resist = {1, 2, 3, 2, 2};

      public static void imprimirMao(int[] cartas){
        for (int j = 0; j < cartas.length; j++) {
       if(cartas[j] == -1){
        System.out.println("*");
        }
        else{
System.out.print(cartas[j]);
        }
       }
      }
      
      public static boolean verificaAtaque(int ataque, int defesa,int[] poder2, int[] resist2,int aux22,int aux33){
        int aux2=aux22, aux3=aux33;
        if(poder2[ataque] >= resist2[defesa]){
        System.out.println("voce ganhou a rodada");
         aux2=aux2+1;
        return true;
      }
    System.out.println("voce perdeu a rodada");
      aux3=aux3+1;
      return false;   
    }
      
    
      public static boolean verificaCarta(int[] cartasMao, int indiceCarta){
      for(int i=0; i<=cartasMao.length; i++){
          if(cartasMao[indiceCarta]!= -1){
          // System.out.println("trueC");
            return true; 
       }     
//       cartasMao[indiceCarta] = -1;
      }
          System.out.println("carta já utilizada");
      return false;
      }
      public static int sorteiaCarta(){
      Random rand = new Random();
      int valorAleatorio = rand.nextInt(5*29)%5;
      return valorAleatorio;
      }
      
      public static void main(String[] args) throws Exception {
       Scanner scam = new Scanner(System.in);
       String[] nome = {"Testemunha Eterna","Pirata de Aeroveleiro","Etergênito Talentoso", "Senhora dos Amaldiçoados", "Peão de Ulamog"};
       int[] poder = {2, 1, 2, 3, 2};
       int[] resist = {1, 2, 3, 2, 2};
       int[] player= new int[6];
       int[] ia= new int[6];
       int[] repeticoes= new int[5];
     
     for (int iP = 0; iP < player.length; iP++) {
     player[iP] = sorteiaCarta();
     repeticoes[player[iP]]++;    
     }
     for (int iA = 0; iA < ia.length; iA++) {
        ia[iA]= sorteiaCarta();
        repeticoes[ia[iA]]++;  
        }
int auxIa = 0;
int aux2=0, aux3=0;
    for (int index = 0; index < ia.length; index++) {
    System.out.println("rodada "+(index+1));
    imprimirMao(player);
    // System.out.println("    ");
    // imprimirMao(ia);
System.out.println("    ");
System.out.println("Jogador, informe qual carta voce deseja utilizar através do indice dela");
int carta = scam.nextInt();
while(carta != 0 & carta != 1 & carta != 2 & carta != 3 & carta != 4 & carta != 5){
    System.out.println("Informe um indice valido");
    carta = scam.nextInt();
}
verificaCarta(player,carta);
verificaCarta(ia,auxIa);
int indicePoderP=player[carta];
int indiceResistIA=ia[auxIa];
// System.out.println("essa eh a auxiliar 3  "+indicePoderP);
// System.out.println("essa eh a auxiliar 4  "+indiceResistIA);
verificaAtaque(indicePoderP,indiceResistIA,poder,resist,aux2,aux3);    
player[carta] = -1;
auxIa = auxIa+1;
}
if(aux2==aux3){
  System.out.println("parabens, vc ganhou o jogo!");
  }
  else{
    System.out.println("vc perdeu");
  }        
int numM = repeticoes[0];
int maiorI=0;
for (int i = 0; i < repeticoes.length; i++) {
  if(repeticoes[i]>numM){
    numM=repeticoes[i];
    maiorI =i;
    System.out.println("A carta mais utilizada na partida foi "+nome[maiorI]);
  }
}
   }
}

      
  
