import pandas as pd;
from sqlalchemy import create_engine

df=pd.read_csv('datos.csv')

# Estructura: 'mysql+pymysql://usuario:contraseña@servidor:puerto/nombre_bd'
engine = create_engine('mysql+pymysql://springboot:canzervero@localhost:3306/persistencia')

# 2. Insertar el DataFrame en la tabla 'nombre_tabla'
df.to_sql(name='municipios', con=engine, if_exists='append', index=False)
