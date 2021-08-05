from modules.data_import import DataImport
if __name__ == '__main__':
    control = DataImport('localhost', 'root', 'root', 'gdesign')
    control.importSql('..\sql\gdesign.sql')
    control.import_commodities(
        '..\datasets\commodities.csv', '..\datasets\commodity_with_value.csv')
    control.import_orders('..\datasets\orders')