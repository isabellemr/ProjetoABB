package classes;

public class NoArvore {

    String nome;
    int rgm;
    NoArvore direita;
    NoArvore esquerda;

    public NoArvore(){
        this.rgm = 0;
        this.nome = null;
        this.direita = null;
        this.esquerda = null;
    }
    public NoArvore(int novovalor, String nome){
        this.rgm = novovalor;
        this.nome = nome;
        this.direita = null;
        this.esquerda = null;
    }

    public NoArvore busca(NoArvore no, int valorprocurado) {
        if(no == null)
            return null;

        if(no.rgm > valorprocurado)
            return busca(no.esquerda, valorprocurado);
        else if(no.rgm < valorprocurado)
            return busca(no.direita, valorprocurado);
        else
            return no;
    }

    public NoArvore insere(NoArvore no, int novovalor, String nomeAluno) {
        if(no == null) {
            no = new NoArvore();
            no.rgm = novovalor;
            no.nome = nomeAluno;
            no.esquerda = no.direita = null;
        }
        else if(novovalor < no.rgm)
            no.esquerda = insere(no.esquerda, novovalor, nomeAluno);
        else if(novovalor > no.rgm)
            no.direita = insere(no.direita, novovalor, nomeAluno);

        return no;
    }

    public void imprime(NoArvore raiz) {
        if (raiz != null) {
            imprime(raiz.esquerda);
            System.out.println("RGM: " + raiz.rgm + "\nNome: " + raiz.nome);
            imprime(raiz.direita);
        }
    }

    public void imprimePre(NoArvore raiz) {
        if (raiz != null) {
            System.out.println("RGM: " + raiz.rgm + "\nNome: " + raiz.nome);
            imprime(raiz.esquerda);
            imprime((raiz.direita));
        }
    }

    public void imprimePos(NoArvore raiz) {
        if (raiz != null) {
            imprime(raiz.esquerda);
            imprime((raiz.direita));
            System.out.println("RGM: " + raiz.rgm + "\nNome: " + raiz.nome);
        }
    }

    public NoArvore remove(NoArvore raiz, int valoraremover) {
        // faz a busca pelo valor a ser removido
        if (raiz == null)
            return null;
        else if (raiz.rgm > valoraremover)
            raiz.esquerda = remove(raiz.esquerda, valoraremover);
        else if (raiz.rgm < valoraremover)
            raiz.direita = remove(raiz.direita, valoraremover);
        else {	// passar por aqui significa que achou o n� com o
            // valora remover procurado e agora vai remov�-lo
            // segundo as 4 situa��es a seguir:
            // N�o ter filhos (esquerda e direita == null)
            if (raiz.esquerda == null && raiz.direita == null) {
                raiz = null;
            }
            // Ter filho apenas � direita (esquerda == null)
            else if (raiz. esquerda == null) {
                raiz = raiz.direita;
            }
            // Ter filho apenas � esquerda (direita == null)
            else if (raiz.direita == null) {
                raiz = raiz.esquerda;
            }
            // Ter dois filhos (esquerda e direita != null)
            else {
                NoArvore sub_esquerda = raiz.esquerda;
                // encontrar o n� com maior valor na sub�rvore esquerda
                while (sub_esquerda.direita != null) {
                    sub_esquerda = sub_esquerda.direita;
                }
                // aqui a sub_esquerda.valor tem o maior valor
                raiz.rgm = sub_esquerda.rgm;
                sub_esquerda.rgm = valoraremover;
                raiz.esquerda = remove(raiz.esquerda, valoraremover);
            }
        }
        return raiz;
    }
}
