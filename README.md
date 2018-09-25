-   数据库关系图

![数据库](https://github.com/dragonhht/GitImgs/blob/master/nures/nures.png?raw=true)

-   数据增删查遵循rest接口(以下以家属为例)

    -   GET     /family     : 列出所有(支持分页，参数为：page(页码)、size(每页数量))
    -   POST    /family    : 新建一条数据(修改可以暂时使用这个)
    -   DELETE  /family/{id}    : 删除指定ID的数据
    -   GET     /family/{id}    :获取指定ID的数据

-   rest接口中，各实体对照

    -   家属： `family`
    -   入住申请：`applyFrom`
    -   床位：`bed`
    -   床位记录：`bedRecord`
    -   护理项目：`nurs`
    -   老人： `person`

