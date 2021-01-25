
export class Product {
        id: string;
        productName: string;
        productDescription: string;
        unitPrice: string;
        imageUrl: string;
        productQuantity: string;
        productCategory:string;

        constructor() {
                this.id = '';
                this.productName = '';
                this.productDescription = '';
                this.unitPrice = '';
                this.imageUrl = '';
                this.productQuantity='';
                this.productCategory='';
        }
}