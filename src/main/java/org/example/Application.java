package org.example;

import org.example.model.*;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) throws MargemLucroException {
        //Declaração de fornecedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Dell Ltda");

        //Declaração de cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Bruno Kurzawe");

        try {
            cliente.getCpf().toUpperCase();
        } catch (Exception e) {
            System.out.println("CPF não informado!");
        }


        Integer calculo;
        try {
            calculo = 10 / 0;
        } catch (ArithmeticException aex) {
            calculo = 0;
        }
        System.out.println(calculo);


        try {
            Integer[] array = {10, 14, 22, 33};
            System.out.println(array[4]);
        } catch (ArrayIndexOutOfBoundsException aiex) {
            System.out.println("Posição não existe!");
        }


        //Declaração de Produto
        Produto produto = new Produto("Computador", "I5 8gb");
        produto.setPrecoCompra(1200.00);
        produto.setPrecoVenda(1400.00);



        Servico servico = new Servico("Instalação Office", 2.0, 100.00);

        //Declaração de Compras
        Compra compra = new Compra();
        compra.setDataCompra(LocalDate.now());
        compra.setFornecedor(fornecedor);
        ItemCompra itemC1 = new ItemCompra(produto, 1000.00, 10.0, 10.0);
        compra.addItemCompra(itemC1);

        //Declaração de Vendas
        Venda venda = new Venda();
        venda.setDataVenda(LocalDate.now());
        venda.setCliente(cliente);
        ItemVenda item = new ItemVenda(produto, 1500.00, 1.0, 10.0);
        venda.addItemVenda(item);

        Venda venda2 = new Venda();
        venda2.setDataVenda(LocalDate.now());
        venda2.setCliente(cliente);
        ItemVenda item2 = new ItemVenda(produto, 1500.00, 1.0, 10.0);
        venda2.addItemVenda(item2);
        ItemVenda item3 = new ItemVenda(servico, 150.00, 1.0, 10.0);
        venda2.addItemVenda(item3);

        //Declaração de Lotacao
        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setDataLocacao(LocalDate.now());
        ItemLocacao itemL1 = new ItemLocacao(produto, 150.00, 10.0, 0.0);
        locacao.addItemLocacao(itemL1);

        Balanco balanco = new Balanco();
        balanco.setId(352578L);
        balanco.setDataBalanco(LocalDate.now());
        balanco.setResponsavel("Maria Luiza");
        balanco.addOperacoes(venda);
        balanco.addOperacoes(venda2);
        balanco.addOperacoes(compra);
        balanco.addOperacoes(locacao);

        balanco.imprimirBalanco();
    }
}






