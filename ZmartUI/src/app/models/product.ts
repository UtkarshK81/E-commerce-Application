
export class Product {
        id: number;
        productName: string;
        productDescription: string;
        unitPrice: number;
        imageUrl: string;
        productQuantity: number;

        constructor(id=0, productName='', productDescription = '', unitPrice = 0, productQuantity = 0, imageUrl = 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR608TWmLRWFNYPlY5xgKkgZPYe7mwv0GDMDtAS9nRdlVo4aytG') {
                this.id = id
                this.productName = productName
                this.productDescription = productDescription
                this.unitPrice = unitPrice
                this.imageUrl = imageUrl
                this.productQuantity=productQuantity
        }
}