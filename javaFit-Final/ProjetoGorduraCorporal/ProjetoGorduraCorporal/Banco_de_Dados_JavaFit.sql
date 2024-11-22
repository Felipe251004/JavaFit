CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    sexo ENUM('M', 'F') NOT NULL,
    medida_punho DECIMAL(5,2) NOT NULL,   -- Medida do punho em cm
    medida_tornozelo DECIMAL(5,2) NOT NULL, -- Medida do tornozelo em cm
    medida_pescoco DECIMAL(5,2) NOT NULL,   -- Medida do pescoço em cm
    largura_abdominal DECIMAL(5,2) NOT NULL, -- Largura abdominal em cm
    altura DECIMAL(5,2) NOT NULL,           -- Altura em cm
    peso DECIMAL(5,2) NOT NULL,             -- Peso em kg
    idade INT NOT NULL                      -- Idade em anos
);
CREATE TABLE Resultados (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    taxa_metabolismo_basl DECIMAL(10,2) NOT NULL, -- Taxa de metabolismo basal em kcal
    imc DECIMAL(5,2) NOT NULL,                    -- Índice de Massa Corporal
    percentual_gordura DECIMAL(5,2) NOT NULL,     -- Percentual de gordura corporal
    litros_consumir DECIMAL(5,2) NOT NULL,        -- Quantidade de litros de água a consumir
    data_calculo DATETIME DEFAULT CURRENT_TIMESTAMP, -- Data do cálculo
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

