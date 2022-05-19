<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="performerName" label="Name" width="180"> </el-table-column>
    <el-table-column prop="performerPic" label="Pic" width="200"></el-table-column>
    <el-table-column prop="performerIntroduction" label="Introduction" width="300"></el-table-column>
    <el-table-column
      prop="performerType"
      label="perfomerType"
      :filters="[{ text: 'violinist', value: 'violinsit' }, { text: 'pianist', value: 'pianist' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          disable-transitions>{{scope.row.performerType}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column   align="right">
        <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>
<script>
export default {
  data () {
    return {
      tableData: [
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        },
        {
          performerName: 'Hilary Hahn',
          performerPic: 'Pic',
          performerIntroduction: 'Hilary Hahn (born November 27, 1979) is an American violinist. She has performed throughout the world as a soloist with leading orchestras and conductors and as a recitalist. She is an avid supporter of contemporary classical music, and several composers have written works for her, including concerti by Edgar Meyer and Jennifer Higdon, partitas by Antón García Abril, two serenades for violin and orchestra by Einojuhani Rautavaara, and a violin and piano sonata by Lera Auerbach.',
          performerType: 'violinist'
        }
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    }
  }
}
</script>
<style scope>

</style>
