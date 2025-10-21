//Gregory de Amorim Oliveira - 325210793
import java.util.Scanner;

public class MonitoramentoJumentos {

    
    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        double taxaReducao = (1 - ((double) populacaoAtual / populacaoInicial)) * 100;
        return taxaReducao;
    }

    
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90.0;
    }

    
    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    
    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        System.out.println("\n--- RESULTADO DA SIMULAÇÃO ---");
        System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");

        if (populacaoRestante <= 0) {
            System.out.println("\nALERTA: A população pode ser EXTINTA se o ritmo continuar!");
        } else {
            System.out.println("\nAinda há esperança! Iniciativas de conservação são vitais.");
        }

        System.out.println("\nPrograma de Monitoramento Finalizado.");
    }

    
    public static void main(String[] args) {
        Scanner fodasse = new Scanner(System.in);

        
        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        System.out.println("=== S.O.S. JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ===");
        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);

        
        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("\n[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        
        boolean riscoCritico = estaEmRiscoCritico(taxaReducao);
        if (riscoCritico) {
            System.out.println("[Status] Espécie em Risco CRÍTICO (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie em condição de risco moderado.");
        }

        
        System.out.print("\nQuantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = fodasse.nextInt();

        
        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        
        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

        fodasse.close();
    }
}
