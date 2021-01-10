import { useEffect, useState } from 'react';
import { fetchProducts, saveOrder } from '../api';
import { checkIsSelected } from './helpers';
import { toast } from 'react-toastify';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrderSummary';
import ProductList from './ProductsList';
import StepsHeader from './StepsHeader';
import './styles.css';
import { OrderLocationData, Product } from './types';

function Order(){

    const [products, setProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);

    const totalPrice = selectedProducts.reduce((sum, curr) => {
        return sum + curr.price;
    },0)

    useEffect(() =>{
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(error => console.error(error));
    }, [])

    const handleSelectProduct = (product: Product) => {
        const isAlreadySelected = checkIsSelected(selectedProducts, product);
      
        if (isAlreadySelected) {
          const selected = selectedProducts.filter(item => item.id !== product.id);
          setSelectedProducts(selected);
        } else {
          setSelectedProducts(previous => [...previous, product]);
        }
      }

    const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }));
        const payload = {
          ...orderLocation!,
          products: productsIds
        }
      
        saveOrder(payload).then((response) => {
          toast.error(`Pedido enviado com sucesso! Nº${response.data.id}`);
          setSelectedProducts([]);
        })
          .catch((err) => {
            if(err.response)
              toast.warning(err.response.data.message);
            else{
              toast.warning('Erro ao enviar pedido');
            }
          })
      }

    return(
        <div className="orders-container">
            <StepsHeader />
            <ProductList
                products={products}
                onSelectProduct={handleSelectProduct}
                selectedProducts={selectedProducts}
            />
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
            <OrderSummary 
                amount={selectedProducts.length}
                totalPrice={totalPrice}
                onSubmit={handleSubmit}
            />
        </div>
    )
}

export default Order;