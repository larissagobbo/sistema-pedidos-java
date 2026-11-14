-- Dados de teste
INSERT INTO cliente (nome, email) VALUES
    ('Estela Silva', 'estelas@email.com'),
    ('Ana Oliveira', 'anaoli10@email.com'),
    ('Ingrid Holanda', 'ingrih5@email.com');

INSERT INTO produto (nome, preco) VALUES
    ('Teclado', 190.00),
    ('Mouse', 100.00),
    ('Monitor', 1500.00);

INSERT INTO pedido (id_cliente) VALUES (1), (2);

INSERT INTO item_pedido (id_pedido, id_produto, quantidade) VALUES
    (1, 1, 1),
    (1, 2, 2),
    (2, 3, 1);

-- Consulta: pedidos completos com subtotal
SELECT
    p.id AS pedido,
    c.nome AS cliente,
    pr.nome AS produto,
    ip.quantidade,
    pr.preco,
    ip.quantidade * pr.preco AS subtotal
FROM pedido p
JOIN cliente c ON c.id = p.id_cliente
JOIN item_pedido ip ON ip.id_pedido = p.id
JOIN produto pr ON pr.id = ip.id_produto
ORDER BY p.id;